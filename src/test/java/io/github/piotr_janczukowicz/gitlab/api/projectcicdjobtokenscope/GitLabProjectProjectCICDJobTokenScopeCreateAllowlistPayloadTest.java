package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTargetProjectIdIsNullable() {
        final GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayloadBuilder builder =
                GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayloadBuilder.builder(
                                ProjectcicdjobtokenscopeCatalogFixtures
                                        .projectProjectCICDJobTokenScopeCreateAllowlistPayload())
                        .targetProjectId(null);

        final GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayload built = builder.build();

        assertThat(built.targetProjectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayload value =
                ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeCreateAllowlistPayload();

        assertThat(value.targetProjectId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayload original =
                ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeCreateAllowlistPayload();

        final GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayload rebuilt =
                GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectCICDJobTokenScopeCreateAllowlistPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("targetProjectId");
    }
}
