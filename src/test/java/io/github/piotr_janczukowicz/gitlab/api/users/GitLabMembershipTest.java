package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMembershipTest {

    @Test
    void constructor_shouldAcceptNull_whenSourceIdIsNullable() {
        final GitLabMembershipBuilder builder = GitLabMembershipBuilder.builder(UsersCatalogFixtures.membership())
                .sourceId(null);

        final GitLabMembership built = builder.build();

        assertThat(built.sourceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceNameIsNullable() {
        final GitLabMembershipBuilder builder = GitLabMembershipBuilder.builder(UsersCatalogFixtures.membership())
                .sourceName(null);

        final GitLabMembership built = builder.build();

        assertThat(built.sourceName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceTypeIsNullable() {
        final GitLabMembershipBuilder builder = GitLabMembershipBuilder.builder(UsersCatalogFixtures.membership())
                .sourceType(null);

        final GitLabMembership built = builder.build();

        assertThat(built.sourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabMembershipBuilder builder = GitLabMembershipBuilder.builder(UsersCatalogFixtures.membership())
                .accessLevel(null);

        final GitLabMembership built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMembership value = UsersCatalogFixtures.membership();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceId()).isEqualTo("source_id");
            softly.assertThat(value.sourceName()).isEqualTo("source_name");
            softly.assertThat(value.sourceType()).isEqualTo("source_type");
            softly.assertThat(value.accessLevel()).isEqualTo("access_level");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMembership original = UsersCatalogFixtures.membership();

        final GitLabMembership rebuilt =
                GitLabMembershipBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMembership.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceId", "sourceName", "sourceType", "accessLevel");
    }
}
