package io.github.piotr_janczukowicz.gitlab.api.errortracking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectErrorTrackingUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabProjectErrorTrackingUpdatePayloadBuilder builder =
                GitLabProjectErrorTrackingUpdatePayloadBuilder.builder(
                                ErrortrackingCatalogFixtures.projectErrorTrackingUpdatePayload())
                        .active(null);

        final GitLabProjectErrorTrackingUpdatePayload built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntegratedIsNullable() {
        final GitLabProjectErrorTrackingUpdatePayloadBuilder builder =
                GitLabProjectErrorTrackingUpdatePayloadBuilder.builder(
                                ErrortrackingCatalogFixtures.projectErrorTrackingUpdatePayload())
                        .integrated(null);

        final GitLabProjectErrorTrackingUpdatePayload built = builder.build();

        assertThat(built.integrated()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectErrorTrackingUpdatePayload value =
                ErrortrackingCatalogFixtures.projectErrorTrackingUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.integrated()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectErrorTrackingUpdatePayload original =
                ErrortrackingCatalogFixtures.projectErrorTrackingUpdatePayload();

        final GitLabProjectErrorTrackingUpdatePayload rebuilt =
                GitLabProjectErrorTrackingUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectErrorTrackingUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("active", "integrated");
    }
}
