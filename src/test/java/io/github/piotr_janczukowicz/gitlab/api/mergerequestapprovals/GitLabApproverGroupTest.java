package io.github.piotr_janczukowicz.gitlab.api.mergerequestapprovals;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApproverGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabApproverGroupBuilder builder = GitLabApproverGroupBuilder.builder(
                        MergerequestapprovalsCatalogFixtures.approverGroup())
                .group(null);

        final GitLabApproverGroup built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApproverGroup value = MergerequestapprovalsCatalogFixtures.approverGroup();

        assertThat(value.group()).isEqualTo(CommonCatalogFixtures.group());
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApproverGroup original = MergerequestapprovalsCatalogFixtures.approverGroup();

        final GitLabApproverGroup rebuilt =
                GitLabApproverGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApproverGroup.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("group");
    }
}
