package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDiffRefsTest {

    @Test
    void constructor_shouldAcceptNull_whenBaseShaIsNullable() {
        final GitLabDiffRefsBuilder builder =
                GitLabDiffRefsBuilder.builder(CommonCatalogFixtures.diffRefs()).baseSha(null);

        final GitLabDiffRefs built = builder.build();

        assertThat(built.baseSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeadShaIsNullable() {
        final GitLabDiffRefsBuilder builder =
                GitLabDiffRefsBuilder.builder(CommonCatalogFixtures.diffRefs()).headSha(null);

        final GitLabDiffRefs built = builder.build();

        assertThat(built.headSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartShaIsNullable() {
        final GitLabDiffRefsBuilder builder =
                GitLabDiffRefsBuilder.builder(CommonCatalogFixtures.diffRefs()).startSha(null);

        final GitLabDiffRefs built = builder.build();

        assertThat(built.startSha()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDiffRefs value = CommonCatalogFixtures.diffRefs();

        assertSoftly(softly -> {
            softly.assertThat(value.baseSha()).isEqualTo("b83d6e391c22777fca1ed3012fce84f633d7fed0");
            softly.assertThat(value.headSha()).isEqualTo("b83d6e391c22777fca1ed3012fce84f633d7fed0");
            softly.assertThat(value.startSha()).isEqualTo("b83d6e391c22777fca1ed3012fce84f633d7fed0");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDiffRefs original = CommonCatalogFixtures.diffRefs();

        final GitLabDiffRefs rebuilt = GitLabDiffRefsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDiffRefs.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("baseSha", "headSha", "startSha");
    }
}
