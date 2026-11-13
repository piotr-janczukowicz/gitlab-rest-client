package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPublicGroupDetailsTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPublicGroupDetailsBuilder builder = GitLabPublicGroupDetailsBuilder.builder(
                        ProjectsCatalogFixtures.publicGroupDetails())
                .id(null);

        final GitLabPublicGroupDetails built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabPublicGroupDetailsBuilder builder = GitLabPublicGroupDetailsBuilder.builder(
                        ProjectsCatalogFixtures.publicGroupDetails())
                .webUrl(null);

        final GitLabPublicGroupDetails built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabPublicGroupDetailsBuilder builder = GitLabPublicGroupDetailsBuilder.builder(
                        ProjectsCatalogFixtures.publicGroupDetails())
                .name(null);

        final GitLabPublicGroupDetails built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabPublicGroupDetailsBuilder builder = GitLabPublicGroupDetailsBuilder.builder(
                        ProjectsCatalogFixtures.publicGroupDetails())
                .avatarUrl(null);

        final GitLabPublicGroupDetails built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullNameIsNullable() {
        final GitLabPublicGroupDetailsBuilder builder = GitLabPublicGroupDetailsBuilder.builder(
                        ProjectsCatalogFixtures.publicGroupDetails())
                .fullName(null);

        final GitLabPublicGroupDetails built = builder.build();

        assertThat(built.fullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabPublicGroupDetailsBuilder builder = GitLabPublicGroupDetailsBuilder.builder(
                        ProjectsCatalogFixtures.publicGroupDetails())
                .fullPath(null);

        final GitLabPublicGroupDetails built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPublicGroupDetails value = ProjectsCatalogFixtures.publicGroupDetails();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.webUrl()).isEqualTo("http://gitlab.example.com/groups/diaspora");
            softly.assertThat(value.name()).isEqualTo("Diaspora");
            softly.assertThat(value.avatarUrl())
                    .isEqualTo("http://gitlab.example.com/uploads/group/avatar/1/avatar.png");
            softly.assertThat(value.fullName()).isEqualTo("Foobar Group");
            softly.assertThat(value.fullPath()).isEqualTo("foo-bar");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPublicGroupDetails original = ProjectsCatalogFixtures.publicGroupDetails();

        final GitLabPublicGroupDetails rebuilt =
                GitLabPublicGroupDetailsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPublicGroupDetails.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "webUrl", "name", "avatarUrl", "fullName", "fullPath");
    }
}
