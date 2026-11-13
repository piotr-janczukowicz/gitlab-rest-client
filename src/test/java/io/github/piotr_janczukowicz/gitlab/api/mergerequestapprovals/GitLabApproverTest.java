package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApproverTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabApproverBuilder builder = GitLabApproverBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approver())
                .user(null);

        final GitLabApprover built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApprover value = MergerequestapprovalsCatalogFixtures.approver();

        assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApprover original = MergerequestapprovalsCatalogFixtures.approver();

        final GitLabApprover rebuilt = GitLabApproverBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApprover.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("user");
    }
}
