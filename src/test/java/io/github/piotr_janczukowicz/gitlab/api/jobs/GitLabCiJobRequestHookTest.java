package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestHookTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobRequestHookBuilder builder = GitLabCiJobRequestHookBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestHook())
                .name(null);

        final GitLabCiJobRequestHook built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScriptIsNullable() {
        final GitLabCiJobRequestHookBuilder builder = GitLabCiJobRequestHookBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestHook())
                .script(null);

        final GitLabCiJobRequestHook built = builder.build();

        assertThat(built.script()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestHook value = JobsCatalogFixtures.ciJobRequestHook();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.script()).isEqualTo(List.of("script"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestHook original = JobsCatalogFixtures.ciJobRequestHook();

        final GitLabCiJobRequestHook rebuilt =
                GitLabCiJobRequestHookBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestHook.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "script");
    }
}
