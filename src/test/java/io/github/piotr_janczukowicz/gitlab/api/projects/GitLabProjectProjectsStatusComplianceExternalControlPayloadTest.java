package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsStatusComplianceExternalControlPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenStatusIsNull() {
        final GitLabProjectProjectsStatusComplianceExternalControlPayloadBuilder builder =
                GitLabProjectProjectsStatusComplianceExternalControlPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsStatusComplianceExternalControlPayload())
                        .status(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("status");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsStatusComplianceExternalControlPayload value =
                ProjectsCatalogFixtures.projectProjectsStatusComplianceExternalControlPayload();

        assertThat(value.status()).isEqualTo(GitLabProjectProjectsStatusComplianceExternalControlStatus.PASS);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsStatusComplianceExternalControlPayload original =
                ProjectsCatalogFixtures.projectProjectsStatusComplianceExternalControlPayload();

        final GitLabProjectProjectsStatusComplianceExternalControlPayload rebuilt =
                GitLabProjectProjectsStatusComplianceExternalControlPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsStatusComplianceExternalControlPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }
}
