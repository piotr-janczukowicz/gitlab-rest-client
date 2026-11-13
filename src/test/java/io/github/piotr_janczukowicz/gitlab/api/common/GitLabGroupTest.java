package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).id(null);

        final GitLabGroup built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).webUrl(null);

        final GitLabGroup built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).name(null);

        final GitLabGroup built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).path(null);

        final GitLabGroup built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).description(null);

        final GitLabGroup built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).visibility(null);

        final GitLabGroup built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShareWithGroupLockIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).shareWithGroupLock(null);

        final GitLabGroup built = builder.build();

        assertThat(built.shareWithGroupLock()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireTwoFactorAuthenticationIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).requireTwoFactorAuthentication(null);

        final GitLabGroup built = builder.build();

        assertThat(built.requireTwoFactorAuthentication()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorGracePeriodIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).twoFactorGracePeriod(null);

        final GitLabGroup built = builder.build();

        assertThat(built.twoFactorGracePeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectCreationLevelIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).projectCreationLevel(null);

        final GitLabGroup built = builder.build();

        assertThat(built.projectCreationLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDevopsEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).autoDevopsEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.autoDevopsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubgroupCreationLevelIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).subgroupCreationLevel(null);

        final GitLabGroup built = builder.build();

        assertThat(built.subgroupCreationLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsDisabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).emailsDisabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.emailsDisabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailsEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).emailsEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.emailsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowDiffPreviewInEmailIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).showDiffPreviewInEmail(null);

        final GitLabGroup built = builder.build();

        assertThat(built.showDiffPreviewInEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMentionsDisabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).mentionsDisabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.mentionsDisabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).lfsEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.lfsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).archived(null);

        final GitLabGroup built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMathRenderingLimitsEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).mathRenderingLimitsEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.mathRenderingLimitsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockMathRenderingLimitsEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).lockMathRenderingLimitsEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.lockMathRenderingLimitsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCrmEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).crmEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.crmEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceAccessTokenNotifyInheritedIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).resourceAccessTokenNotifyInherited(null);

        final GitLabGroup built = builder.build();

        assertThat(built.resourceAccessTokenNotifyInherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockResourceAccessTokenNotifyInheritedIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).lockResourceAccessTokenNotifyInherited(null);

        final GitLabGroup built = builder.build();

        assertThat(built.lockResourceAccessTokenNotifyInherited()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).defaultBranch(null);

        final GitLabGroup built = builder.build();

        assertThat(built.defaultBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchProtectionIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).defaultBranchProtection(null);

        final GitLabGroup built = builder.build();

        assertThat(built.defaultBranchProtection()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchProtectionDefaultsIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).defaultBranchProtectionDefaults(null);

        final GitLabGroup built = builder.build();

        assertThat(built.defaultBranchProtectionDefaults()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).avatarUrl(null);

        final GitLabGroup built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequestAccessEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).requestAccessEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.requestAccessEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullNameIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).fullName(null);

        final GitLabGroup built = builder.build();

        assertThat(built.fullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).fullPath(null);

        final GitLabGroup built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).createdAt(null);

        final GitLabGroup built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).parentId(null);

        final GitLabGroup built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).organizationId(null);

        final GitLabGroup built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSharedRunnersSettingIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).sharedRunnersSetting(null);

        final GitLabGroup built = builder.build();

        assertThat(built.sharedRunnersSetting()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsSizeIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).maxArtifactsSize(null);

        final GitLabGroup built = builder.build();

        assertThat(built.maxArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).customAttributes(null);

        final GitLabGroup built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatisticsIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).statistics(null);

        final GitLabGroup built = builder.build();

        assertThat(built.statistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkedForDeletionOnIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).markedForDeletionOn(null);

        final GitLabGroup built = builder.build();

        assertThat(built.markedForDeletionOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootStorageStatisticsIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).rootStorageStatistics(null);

        final GitLabGroup built = builder.build();

        assertThat(built.rootStorageStatistics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLdapCnIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).ldapCn(null);

        final GitLabGroup built = builder.build();

        assertThat(built.ldapCn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLdapAccessIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).ldapAccess(null);

        final GitLabGroup built = builder.build();

        assertThat(built.ldapAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLdapGroupLinksIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).ldapGroupLinks(null);

        final GitLabGroup built = builder.build();

        assertThat(built.ldapGroupLinks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSamlGroupLinksIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).samlGroupLinks(null);

        final GitLabGroup built = builder.build();

        assertThat(built.samlGroupLinks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileTemplateProjectIdIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).fileTemplateProjectId(null);

        final GitLabGroup built = builder.build();

        assertThat(built.fileTemplateProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiAccessLevelIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).wikiAccessLevel(null);

        final GitLabGroup built = builder.build();

        assertThat(built.wikiAccessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).repositoryStorage(null);

        final GitLabGroup built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCoreFeaturesEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).duoCoreFeaturesEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.duoCoreFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoFeaturesEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).duoFeaturesEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.duoFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockDuoFeaturesEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).lockDuoFeaturesEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.lockDuoFeaturesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoDuoCodeReviewEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).autoDuoCodeReviewEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.autoDuoCodeReviewEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDepthAllowedIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).duoCodeReviewDepthAllowed(null);

        final GitLabGroup built = builder.build();

        assertThat(built.duoCodeReviewDepthAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDefaultDepthIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).duoCodeReviewDefaultDepth(null);

        final GitLabGroup built = builder.build();

        assertThat(built.duoCodeReviewDefaultDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoCodeReviewDecisionsEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).duoCodeReviewDecisionsEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.duoCodeReviewDecisionsEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebBasedCommitSigningEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).webBasedCommitSigningEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.webBasedCommitSigningEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowPersonalSnippetsIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).allowPersonalSnippets(null);

        final GitLabGroup built = builder.build();

        assertThat(built.allowPersonalSnippets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoNamespaceAccessRulesIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).duoNamespaceAccessRules(null);

        final GitLabGroup built = builder.build();

        assertThat(built.duoNamespaceAccessRules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBuiltInProjectTemplatesEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).builtInProjectTemplatesEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.builtInProjectTemplatesEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockBuiltInProjectTemplatesEnabledIsNullable() {
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).lockBuiltInProjectTemplatesEnabled(null);

        final GitLabGroup built = builder.build();

        assertThat(built.lockBuiltInProjectTemplatesEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroup value = CommonCatalogFixtures.group();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.webUrl()).isEqualTo("http://gitlab.example.com/groups/diaspora");
            softly.assertThat(value.name()).isEqualTo("Diaspora");
            softly.assertThat(value.path()).isEqualTo("path");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.visibility()).isEqualTo("visibility");
            softly.assertThat(value.shareWithGroupLock()).isEqualTo(true);
            softly.assertThat(value.requireTwoFactorAuthentication()).isEqualTo(true);
            softly.assertThat(value.twoFactorGracePeriod()).isEqualTo(1);
            softly.assertThat(value.projectCreationLevel()).isEqualTo("project_creation_level");
            softly.assertThat(value.autoDevopsEnabled()).isEqualTo(true);
            softly.assertThat(value.subgroupCreationLevel()).isEqualTo("subgroup_creation_level");
            softly.assertThat(value.emailsDisabled()).isEqualTo(true);
            softly.assertThat(value.emailsEnabled()).isEqualTo(true);
            softly.assertThat(value.showDiffPreviewInEmail()).isEqualTo(true);
            softly.assertThat(value.mentionsDisabled()).isEqualTo(true);
            softly.assertThat(value.lfsEnabled()).isEqualTo(true);
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.mathRenderingLimitsEnabled()).isEqualTo(true);
            softly.assertThat(value.lockMathRenderingLimitsEnabled()).isEqualTo(true);
            softly.assertThat(value.crmEnabled()).isEqualTo(true);
            softly.assertThat(value.resourceAccessTokenNotifyInherited()).isEqualTo(true);
            softly.assertThat(value.lockResourceAccessTokenNotifyInherited()).isEqualTo(true);
            softly.assertThat(value.defaultBranch()).isEqualTo("default_branch");
            softly.assertThat(value.defaultBranchProtection()).isEqualTo(1);
            softly.assertThat(value.defaultBranchProtectionDefaults())
                    .isEqualTo(CommonCatalogFixtures.groupDefaultBranchProtectionDefaults());
            softly.assertThat(value.avatarUrl()).isEqualTo("avatar_url");
            softly.assertThat(value.requestAccessEnabled()).isEqualTo(true);
            softly.assertThat(value.fullName()).isEqualTo("full_name");
            softly.assertThat(value.fullPath()).isEqualTo("full_path");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.parentId()).isEqualTo(1L);
            softly.assertThat(value.organizationId()).isEqualTo(1L);
            softly.assertThat(value.sharedRunnersSetting()).isEqualTo("shared_runners_setting");
            softly.assertThat(value.maxArtifactsSize()).isEqualTo(1L);
            softly.assertThat(value.customAttributes()).isEqualTo(List.of(CommonCatalogFixtures.customAttribute()));
            softly.assertThat(value.statistics()).isEqualTo(CommonCatalogFixtures.groupStatistics());
            softly.assertThat(value.markedForDeletionOn()).isEqualTo("marked_for_deletion_on");
            softly.assertThat(value.rootStorageStatistics())
                    .isEqualTo(CommonCatalogFixtures.namespaceRootStorageStatistics());
            softly.assertThat(value.ldapCn()).isEqualTo("ldap_cn");
            softly.assertThat(value.ldapAccess()).isEqualTo("ldap_access");
            softly.assertThat(value.ldapGroupLinks()).isEqualTo(CommonCatalogFixtures.ldapGroupLink());
            softly.assertThat(value.samlGroupLinks()).isEqualTo(CommonCatalogFixtures.samlGroupLink());
            softly.assertThat(value.fileTemplateProjectId()).isEqualTo(1L);
            softly.assertThat(value.wikiAccessLevel()).isEqualTo("wiki_access_level");
            softly.assertThat(value.repositoryStorage()).isEqualTo("repository_storage");
            softly.assertThat(value.duoCoreFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.duoFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.lockDuoFeaturesEnabled()).isEqualTo(true);
            softly.assertThat(value.autoDuoCodeReviewEnabled()).isEqualTo("auto_duo_code_review_enabled");
            softly.assertThat(value.duoCodeReviewDepthAllowed()).isEqualTo(true);
            softly.assertThat(value.duoCodeReviewDefaultDepth()).isEqualTo("standard");
            softly.assertThat(value.duoCodeReviewDecisionsEnabled()).isEqualTo("duo_code_review_decisions_enabled");
            softly.assertThat(value.webBasedCommitSigningEnabled()).isEqualTo(true);
            softly.assertThat(value.allowPersonalSnippets()).isEqualTo("allow_personal_snippets");
            softly.assertThat(value.duoNamespaceAccessRules()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.builtInProjectTemplatesEnabled()).isEqualTo(true);
            softly.assertThat(value.lockBuiltInProjectTemplatesEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroup original = CommonCatalogFixtures.group();

        final GitLabGroup rebuilt = GitLabGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabGroupBuilder builder =
                GitLabGroupBuilder.builder(CommonCatalogFixtures.group()).createdAt(instant);

        final GitLabGroup built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroup.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "webUrl",
                        "name",
                        "path",
                        "description",
                        "visibility",
                        "shareWithGroupLock",
                        "requireTwoFactorAuthentication",
                        "twoFactorGracePeriod",
                        "projectCreationLevel",
                        "autoDevopsEnabled",
                        "subgroupCreationLevel",
                        "emailsDisabled",
                        "emailsEnabled",
                        "showDiffPreviewInEmail",
                        "mentionsDisabled",
                        "lfsEnabled",
                        "archived",
                        "mathRenderingLimitsEnabled",
                        "lockMathRenderingLimitsEnabled",
                        "crmEnabled",
                        "resourceAccessTokenNotifyInherited",
                        "lockResourceAccessTokenNotifyInherited",
                        "defaultBranch",
                        "defaultBranchProtection",
                        "defaultBranchProtectionDefaults",
                        "avatarUrl",
                        "requestAccessEnabled",
                        "fullName",
                        "fullPath",
                        "createdAt",
                        "parentId",
                        "organizationId",
                        "sharedRunnersSetting",
                        "maxArtifactsSize",
                        "customAttributes",
                        "statistics",
                        "markedForDeletionOn",
                        "rootStorageStatistics",
                        "ldapCn",
                        "ldapAccess",
                        "ldapGroupLinks",
                        "samlGroupLinks",
                        "fileTemplateProjectId",
                        "wikiAccessLevel",
                        "repositoryStorage",
                        "duoCoreFeaturesEnabled",
                        "duoFeaturesEnabled",
                        "lockDuoFeaturesEnabled",
                        "autoDuoCodeReviewEnabled",
                        "duoCodeReviewDepthAllowed",
                        "duoCodeReviewDefaultDepth",
                        "duoCodeReviewDecisionsEnabled",
                        "webBasedCommitSigningEnabled",
                        "allowPersonalSnippets",
                        "duoNamespaceAccessRules",
                        "builtInProjectTemplatesEnabled",
                        "lockBuiltInProjectTemplatesEnabled");
    }
}
