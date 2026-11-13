package io.github.piotr_janczukowicz.gitlab.api.jiraforgesubscriptions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabJiraConnectGroupEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabJiraConnectGroupEntityBuilder builder = GitLabJiraConnectGroupEntityBuilder.builder(
                        JiraforgesubscriptionsCatalogFixtures.jiraConnectGroupEntity())
                .name(null);

        final GitLabJiraConnectGroupEntity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabJiraConnectGroupEntityBuilder builder = GitLabJiraConnectGroupEntityBuilder.builder(
                        JiraforgesubscriptionsCatalogFixtures.jiraConnectGroupEntity())
                .avatarUrl(null);

        final GitLabJiraConnectGroupEntity built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullNameIsNullable() {
        final GitLabJiraConnectGroupEntityBuilder builder = GitLabJiraConnectGroupEntityBuilder.builder(
                        JiraforgesubscriptionsCatalogFixtures.jiraConnectGroupEntity())
                .fullName(null);

        final GitLabJiraConnectGroupEntity built = builder.build();

        assertThat(built.fullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabJiraConnectGroupEntityBuilder builder = GitLabJiraConnectGroupEntityBuilder.builder(
                        JiraforgesubscriptionsCatalogFixtures.jiraConnectGroupEntity())
                .description(null);

        final GitLabJiraConnectGroupEntity built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabJiraConnectGroupEntity value = JiraforgesubscriptionsCatalogFixtures.jiraConnectGroupEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.avatarUrl()).isEqualTo("avatar_url");
            softly.assertThat(value.fullName()).isEqualTo("full_name");
            softly.assertThat(value.description()).isEqualTo("description");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabJiraConnectGroupEntity original = JiraforgesubscriptionsCatalogFixtures.jiraConnectGroupEntity();

        final GitLabJiraConnectGroupEntity rebuilt =
                GitLabJiraConnectGroupEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabJiraConnectGroupEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "avatarUrl", "fullName", "description");
    }
}
