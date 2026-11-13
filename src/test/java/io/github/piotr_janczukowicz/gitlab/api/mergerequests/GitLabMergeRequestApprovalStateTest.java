package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestApprovalStateTest {

    @Test
    void constructor_shouldAcceptNull_whenApprovalRulesOverwrittenIsNullable() {
        final GitLabMergeRequestApprovalStateBuilder builder = GitLabMergeRequestApprovalStateBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalState())
                .approvalRulesOverwritten(null);

        final GitLabMergeRequestApprovalState built = builder.build();

        assertThat(built.approvalRulesOverwritten()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRulesIsNullable() {
        final GitLabMergeRequestApprovalStateBuilder builder = GitLabMergeRequestApprovalStateBuilder.builder(
                        MergerequestsCatalogFixtures.mergeRequestApprovalState())
                .rules(null);

        final GitLabMergeRequestApprovalState built = builder.build();

        assertThat(built.rules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestApprovalState value = MergerequestsCatalogFixtures.mergeRequestApprovalState();

        assertSoftly(softly -> {
            softly.assertThat(value.approvalRulesOverwritten()).isEqualTo(true);
            softly.assertThat(value.rules())
                    .isEqualTo(List.of(MergerequestsCatalogFixtures.mergeRequestApprovalStateRule()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestApprovalState original = MergerequestsCatalogFixtures.mergeRequestApprovalState();

        final GitLabMergeRequestApprovalState rebuilt =
                GitLabMergeRequestApprovalStateBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestApprovalState.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("approvalRulesOverwritten", "rules");
    }
}
