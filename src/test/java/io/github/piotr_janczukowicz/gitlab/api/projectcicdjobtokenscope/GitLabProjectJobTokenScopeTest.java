package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobTokenScopeTest {

    @Test
    void constructor_shouldAcceptNull_whenInboundEnabledIsNullable() {
        final GitLabProjectJobTokenScopeBuilder builder = GitLabProjectJobTokenScopeBuilder.builder(
                        ProjectcicdjobtokenscopeCatalogFixtures.projectJobTokenScope())
                .inboundEnabled(null);

        final GitLabProjectJobTokenScope built = builder.build();

        assertThat(built.inboundEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOutboundEnabledIsNullable() {
        final GitLabProjectJobTokenScopeBuilder builder = GitLabProjectJobTokenScopeBuilder.builder(
                        ProjectcicdjobtokenscopeCatalogFixtures.projectJobTokenScope())
                .outboundEnabled(null);

        final GitLabProjectJobTokenScope built = builder.build();

        assertThat(built.outboundEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobTokenScope value = ProjectcicdjobtokenscopeCatalogFixtures.projectJobTokenScope();

        assertSoftly(softly -> {
            softly.assertThat(value.inboundEnabled()).isEqualTo(true);
            softly.assertThat(value.outboundEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobTokenScope original = ProjectcicdjobtokenscopeCatalogFixtures.projectJobTokenScope();

        final GitLabProjectJobTokenScope rebuilt =
                GitLabProjectJobTokenScopeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobTokenScope.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("inboundEnabled", "outboundEnabled");
    }
}
