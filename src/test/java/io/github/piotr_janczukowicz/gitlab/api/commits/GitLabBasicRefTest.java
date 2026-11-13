package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBasicRefTest {

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabBasicRefBuilder builder =
                GitLabBasicRefBuilder.builder(CommitsCatalogFixtures.basicRef()).type(null);

        final GitLabBasicRef built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabBasicRefBuilder builder =
                GitLabBasicRefBuilder.builder(CommitsCatalogFixtures.basicRef()).name(null);

        final GitLabBasicRef built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBasicRef value = CommitsCatalogFixtures.basicRef();

        assertSoftly(softly -> {
            softly.assertThat(value.type()).isEqualTo("tag");
            softly.assertThat(value.name()).isEqualTo("v1.1.0");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBasicRef original = CommitsCatalogFixtures.basicRef();

        final GitLabBasicRef rebuilt = GitLabBasicRefBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBasicRef.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("type", "name");
    }
}
