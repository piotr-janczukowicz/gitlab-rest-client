package io.github.piotr_janczukowicz.gitlab.api.avatar;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAvatarTest {

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabAvatarBuilder builder =
                GitLabAvatarBuilder.builder(AvatarCatalogFixtures.avatar()).avatarUrl(null);

        final GitLabAvatar built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAvatar value = AvatarCatalogFixtures.avatar();

        assertThat(value.avatarUrl()).isEqualTo("https://example.com/avatar.png");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAvatar original = AvatarCatalogFixtures.avatar();

        final GitLabAvatar rebuilt = GitLabAvatarBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAvatar.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("avatarUrl");
    }
}
