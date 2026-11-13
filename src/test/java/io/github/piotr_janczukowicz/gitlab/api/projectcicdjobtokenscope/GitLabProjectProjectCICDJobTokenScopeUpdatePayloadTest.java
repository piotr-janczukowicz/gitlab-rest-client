package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectCICDJobTokenScopeUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabProjectProjectCICDJobTokenScopeUpdatePayloadBuilder builder =
                GitLabProjectProjectCICDJobTokenScopeUpdatePayloadBuilder.builder(
                                ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeUpdatePayload())
                        .enabled(null);

        final GitLabProjectProjectCICDJobTokenScopeUpdatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectCICDJobTokenScopeUpdatePayload value =
                ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeUpdatePayload();

        assertThat(value.enabled()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectCICDJobTokenScopeUpdatePayload original =
                ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeUpdatePayload();

        final GitLabProjectProjectCICDJobTokenScopeUpdatePayload rebuilt =
                GitLabProjectProjectCICDJobTokenScopeUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectCICDJobTokenScopeUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("enabled");
    }
}
