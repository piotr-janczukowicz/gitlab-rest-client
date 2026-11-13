package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProtectedPackagesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageNamePatternIsNullable() {
        final GitLabProjectProtectedPackagesUpdatePayloadBuilder builder =
                GitLabProjectProtectedPackagesUpdatePayloadBuilder.builder(
                                ProtectedpackagesCatalogFixtures.projectProtectedPackagesUpdatePayload())
                        .packageNamePattern(null);

        final GitLabProjectProtectedPackagesUpdatePayload built = builder.build();

        assertThat(built.packageNamePattern()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageTypeIsNullable() {
        final GitLabProjectProtectedPackagesUpdatePayloadBuilder builder =
                GitLabProjectProtectedPackagesUpdatePayloadBuilder.builder(
                                ProtectedpackagesCatalogFixtures.projectProtectedPackagesUpdatePayload())
                        .packageType(null);

        final GitLabProjectProtectedPackagesUpdatePayload built = builder.build();

        assertThat(built.packageType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForDeleteIsNullable() {
        final GitLabProjectProtectedPackagesUpdatePayloadBuilder builder =
                GitLabProjectProtectedPackagesUpdatePayloadBuilder.builder(
                                ProtectedpackagesCatalogFixtures.projectProtectedPackagesUpdatePayload())
                        .minimumAccessLevelForDelete(null);

        final GitLabProjectProtectedPackagesUpdatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForDelete()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForPushIsNullable() {
        final GitLabProjectProtectedPackagesUpdatePayloadBuilder builder =
                GitLabProjectProtectedPackagesUpdatePayloadBuilder.builder(
                                ProtectedpackagesCatalogFixtures.projectProtectedPackagesUpdatePayload())
                        .minimumAccessLevelForPush(null);

        final GitLabProjectProtectedPackagesUpdatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedPackagesUpdatePayload value =
                ProtectedpackagesCatalogFixtures.projectProtectedPackagesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.packageNamePattern()).isEqualTo("package_name_pattern");
            softly.assertThat(value.packageType()).isEqualTo(GitLabProjectProtectedPackagesUpdatePackageType.CARGO);
            softly.assertThat(value.minimumAccessLevelForDelete())
                    .isEqualTo(GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForDelete.OWNER);
            softly.assertThat(value.minimumAccessLevelForPush())
                    .isEqualTo(GitLabProjectProtectedPackagesUpdateMinimumAccessLevelForPush.MAINTAINER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedPackagesUpdatePayload original =
                ProtectedpackagesCatalogFixtures.projectProtectedPackagesUpdatePayload();

        final GitLabProjectProtectedPackagesUpdatePayload rebuilt =
                GitLabProjectProtectedPackagesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProtectedPackagesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "packageNamePattern",
                        "packageType",
                        "minimumAccessLevelForDelete",
                        "minimumAccessLevelForPush");
    }
}
