package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingGlobalTest {

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchSnippetTitlesEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchSnippetTitlesEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchSnippetTitlesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchUsersEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchUsersEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchUsersEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchGroupsEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchGroupsEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchGroupsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchWorkItemsEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchWorkItemsEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchWorkItemsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchMergeRequestsEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchMergeRequestsEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchMergeRequestsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchBlockAnonymousSearchesEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchBlockAnonymousSearchesEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchBlockAnonymousSearchesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchCodeEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchCodeEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchCodeEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchCommitsEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchCommitsEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchCommitsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchWikiEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchWikiEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchWikiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGlobalSearchLimitedIndexingEnabledIsNullable() {
        final GitLabApplicationSettingGlobalBuilder builder = GitLabApplicationSettingGlobalBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingGlobal())
                .globalSearchLimitedIndexingEnabled(null);

        final GitLabApplicationSettingGlobal built = builder.build();

        assertThat(built.globalSearchLimitedIndexingEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingGlobal value = SettingsCatalogFixtures.applicationSettingGlobal();

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
        final GitLabApplicationSettingGlobal original = SettingsCatalogFixtures.applicationSettingGlobal();

        final GitLabApplicationSettingGlobal rebuilt =
                GitLabApplicationSettingGlobalBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingGlobal.class.getRecordComponents())
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
