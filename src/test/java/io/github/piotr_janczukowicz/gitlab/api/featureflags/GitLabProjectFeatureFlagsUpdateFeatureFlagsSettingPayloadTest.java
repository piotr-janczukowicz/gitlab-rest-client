package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenMinimumRoleIsNull() {
        final GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayloadBuilder builder =
                GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateFeatureFlagsSettingPayload())
                        .minimumRole(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("minimumRole");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayload value =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateFeatureFlagsSettingPayload();

        assertThat(value.minimumRole())
                .isEqualTo(GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole.NO_ONE_ALLOWED);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayload original =
                FeatureflagsCatalogFixtures.projectFeatureFlagsUpdateFeatureFlagsSettingPayload();

        final GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayload rebuilt =
                GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("minimumRole");
    }
}
