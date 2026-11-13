package io.github.piotr_janczukowicz.gitlab.api.composerdistributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectComposerDistributionsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabProjectComposerDistributionsCreatePayloadBuilder builder =
                GitLabProjectComposerDistributionsCreatePayloadBuilder.builder(
                                ComposerdistributionsCatalogFixtures.projectComposerDistributionsCreatePayload())
                        .branch(null);

        final GitLabProjectComposerDistributionsCreatePayload built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagIsNullable() {
        final GitLabProjectComposerDistributionsCreatePayloadBuilder builder =
                GitLabProjectComposerDistributionsCreatePayloadBuilder.builder(
                                ComposerdistributionsCatalogFixtures.projectComposerDistributionsCreatePayload())
                        .tag(null);

        final GitLabProjectComposerDistributionsCreatePayload built = builder.build();

        assertThat(built.tag()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectComposerDistributionsCreatePayload value =
                ComposerdistributionsCatalogFixtures.projectComposerDistributionsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.branch()).isEqualTo("release");
            softly.assertThat(value.tag()).isEqualTo("v1.0.0");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectComposerDistributionsCreatePayload original =
                ComposerdistributionsCatalogFixtures.projectComposerDistributionsCreatePayload();

        final GitLabProjectComposerDistributionsCreatePayload rebuilt =
                GitLabProjectComposerDistributionsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectComposerDistributionsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("branch", "tag");
    }
}
