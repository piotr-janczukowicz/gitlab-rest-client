package io.github.piotr_janczukowicz.gitlab.api.protectedtags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProtectedTagTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProtectedTagBuilder builder = GitLabProtectedTagBuilder.builder(
                        ProtectedtagsCatalogFixtures.protectedTag())
                .name(null);

        final GitLabProtectedTag built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreateAccessLevelsIsNullable() {
        final GitLabProtectedTagBuilder builder = GitLabProtectedTagBuilder.builder(
                        ProtectedtagsCatalogFixtures.protectedTag())
                .createAccessLevels(null);

        final GitLabProtectedTag built = builder.build();

        assertThat(built.createAccessLevels()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProtectedTag value = ProtectedtagsCatalogFixtures.protectedTag();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("release-1-0");
            softly.assertThat(value.createAccessLevels())
                    .isEqualTo(List.of(CommonCatalogFixtures.protectedRefAccess()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProtectedTag original = ProtectedtagsCatalogFixtures.protectedTag();

        final GitLabProtectedTag rebuilt =
                GitLabProtectedTagBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProtectedTag.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "createAccessLevels");
    }
}
