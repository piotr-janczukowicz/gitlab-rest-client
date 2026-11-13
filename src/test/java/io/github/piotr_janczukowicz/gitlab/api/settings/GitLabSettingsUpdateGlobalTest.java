package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateGlobalTest {

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchSnippetTitlesEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchSnippetTitlesEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchSnippetTitlesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchUsersEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchUsersEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchUsersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchGroupsEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchGroupsEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchGroupsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchWorkItemsEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchWorkItemsEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchWorkItemsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchMergeRequestsEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchMergeRequestsEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchMergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchBlockAnonymousSearchesEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchBlockAnonymousSearchesEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchBlockAnonymousSearchesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchCodeEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchCodeEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchCodeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchCommitsEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchCommitsEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchCommitsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchWikiEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchWikiEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchWikiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchLimitedIndexingEnabledIsNullable() {
        final GitLabSettingsUpdateGlobalBuilder builder = GitLabSettingsUpdateGlobalBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateGlobal())
                .globalSearchLimitedIndexingEnabled(null);

        final GitLabSettingsUpdateGlobal built = builder.build();

        assertThat(built.globalSearchLimitedIndexingEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateGlobal value = SettingsCatalogFixtures.settingsUpdateGlobal();

        assertSoftly(softly -> {
            softly.assertThat(value.globalSearchSnippetTitlesEnabled())
                    .isEqualTo("global_search_snippet_titles_enabled");
            softly.assertThat(value.globalSearchUsersEnabled()).isEqualTo("global_search_users_enabled");
            softly.assertThat(value.globalSearchGroupsEnabled()).isEqualTo("global_search_groups_enabled");
            softly.assertThat(value.globalSearchWorkItemsEnabled()).isEqualTo("global_search_work_items_enabled");
            softly.assertThat(value.globalSearchMergeRequestsEnabled())
                    .isEqualTo("global_search_merge_requests_enabled");
            softly.assertThat(value.globalSearchBlockAnonymousSearchesEnabled())
                    .isEqualTo("global_search_block_anonymous_searches_enabled");
            softly.assertThat(value.globalSearchCodeEnabled()).isEqualTo("global_search_code_enabled");
            softly.assertThat(value.globalSearchCommitsEnabled()).isEqualTo("global_search_commits_enabled");
            softly.assertThat(value.globalSearchWikiEnabled()).isEqualTo("global_search_wiki_enabled");
            softly.assertThat(value.globalSearchLimitedIndexingEnabled())
                    .isEqualTo("global_search_limited_indexing_enabled");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateGlobal original = SettingsCatalogFixtures.settingsUpdateGlobal();

        final GitLabSettingsUpdateGlobal rebuilt =
                GitLabSettingsUpdateGlobalBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateGlobal.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "globalSearchSnippetTitlesEnabled",
                        "globalSearchUsersEnabled",
                        "globalSearchGroupsEnabled",
                        "globalSearchWorkItemsEnabled",
                        "globalSearchMergeRequestsEnabled",
                        "globalSearchBlockAnonymousSearchesEnabled",
                        "globalSearchCodeEnabled",
                        "globalSearchCommitsEnabled",
                        "globalSearchWikiEnabled",
                        "globalSearchLimitedIndexingEnabled");
    }
}
