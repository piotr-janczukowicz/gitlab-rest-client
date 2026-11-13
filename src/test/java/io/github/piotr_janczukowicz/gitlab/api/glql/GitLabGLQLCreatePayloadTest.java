package io.github.piotr_janczukowicz.gitlab.api.glql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGLQLCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenGlqlYamlIsNullable() {
        final GitLabGLQLCreatePayloadBuilder builder = GitLabGLQLCreatePayloadBuilder.builder(
                        GlqlCatalogFixtures.glqlcreatePayload())
                .glqlYaml(null);

        final GitLabGLQLCreatePayload built = builder.build();

        assertThat(built.glqlYaml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAfterIsNullable() {
        final GitLabGLQLCreatePayloadBuilder builder = GitLabGLQLCreatePayloadBuilder.builder(
                        GlqlCatalogFixtures.glqlcreatePayload())
                .after(null);

        final GitLabGLQLCreatePayload built = builder.build();

        assertThat(built.after()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGLQLCreatePayload value = GlqlCatalogFixtures.glqlcreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.glqlYaml()).isEqualTo("glql_yaml");
            softly.assertThat(value.after()).isEqualTo("after");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGLQLCreatePayload original = GlqlCatalogFixtures.glqlcreatePayload();

        final GitLabGLQLCreatePayload rebuilt =
                GitLabGLQLCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGLQLCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("glqlYaml", "after");
    }
}
