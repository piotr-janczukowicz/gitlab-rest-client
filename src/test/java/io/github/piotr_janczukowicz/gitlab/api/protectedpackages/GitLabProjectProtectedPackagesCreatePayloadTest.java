package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProtectedPackagesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageNamePatternIsNullable() {
        final GitLabProjectProtectedPackagesCreatePayloadBuilder builder =
                GitLabProjectProtectedPackagesCreatePayloadBuilder.builder(
                                ProtectedpackagesCatalogFixtures.projectProtectedPackagesCreatePayload())
                        .packageNamePattern(null);

        final GitLabProjectProtectedPackagesCreatePayload built = builder.build();

        assertThat(built.packageNamePattern()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenPackageTypeIsNull() {
        final GitLabProjectProtectedPackagesCreatePayloadBuilder builder =
                GitLabProjectProtectedPackagesCreatePayloadBuilder.builder(
                                ProtectedpackagesCatalogFixtures.projectProtectedPackagesCreatePayload())
                        .packageType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("packageType");
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForDeleteIsNullable() {
        final GitLabProjectProtectedPackagesCreatePayloadBuilder builder =
                GitLabProjectProtectedPackagesCreatePayloadBuilder.builder(
                                ProtectedpackagesCatalogFixtures.projectProtectedPackagesCreatePayload())
                        .minimumAccessLevelForDelete(null);

        final GitLabProjectProtectedPackagesCreatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForDelete()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForPushIsNullable() {
        final GitLabProjectProtectedPackagesCreatePayloadBuilder builder =
                GitLabProjectProtectedPackagesCreatePayloadBuilder.builder(
                                ProtectedpackagesCatalogFixtures.projectProtectedPackagesCreatePayload())
                        .minimumAccessLevelForPush(null);

        final GitLabProjectProtectedPackagesCreatePayload built = builder.build();

        assertThat(built.minimumAccessLevelForPush()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProtectedPackagesCreatePayload value =
                ProtectedpackagesCatalogFixtures.projectProtectedPackagesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.packageNamePattern()).isEqualTo("package_name_pattern");
            softly.assertThat(value.packageType()).isEqualTo(GitLabProjectProtectedPackagesCreatePackageType.CARGO);
            softly.assertThat(value.minimumAccessLevelForDelete())
                    .isEqualTo(GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete.OWNER);
            softly.assertThat(value.minimumAccessLevelForPush())
                    .isEqualTo(GitLabProjectProtectedPackagesCreateMinimumAccessLevelForPush.MAINTAINER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProtectedPackagesCreatePayload original =
                ProtectedpackagesCatalogFixtures.projectProtectedPackagesCreatePayload();

        final GitLabProjectProtectedPackagesCreatePayload rebuilt =
                GitLabProjectProtectedPackagesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProtectedPackagesCreatePayload.class.getRecordComponents())
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
