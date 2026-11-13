package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersListFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .username(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternUidIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .externUid(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.externUid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .publicEmail(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .provider(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .search(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .active(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHumansIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .humans(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.humans()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .external(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.external()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockedIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .blocked(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.blocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAfterIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .createdAfter(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.createdAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedBeforeIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .createdBefore(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.createdBefore()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithoutProjectsIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .withoutProjects(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.withoutProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithoutProjectBotsIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .withoutProjectBots(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.withoutProjectBots()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdminsIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .admins(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.admins()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTwoFactorIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .twoFactor(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.twoFactor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludeActiveIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .excludeActive(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.excludeActive()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludeExternalIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .excludeExternal(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.excludeExternal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludeHumansIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .excludeHumans(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.excludeHumans()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludeInternalIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .excludeInternal(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.excludeInternal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWithCustomAttributesIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .withCustomAttributes(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.withCustomAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .customAttributes(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipLdapIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .skipLdap(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.skipLdap()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuditorsIsNullable() {
        final GitLabUsersListFilterBuilder builder = GitLabUsersListFilterBuilder.builder(
                        GitLabUsersListFilterBuilder.builder()
                                .username("username")
                                .externUid("extern_uid")
                                .publicEmail("public_email")
                                .provider("provider")
                                .search("search")
                                .active(true)
                                .humans(true)
                                .external(true)
                                .blocked(true)
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .withoutProjects(true)
                                .withoutProjectBots(true)
                                .admins(true)
                                .twoFactor("two_factor")
                                .excludeActive(true)
                                .excludeExternal(true)
                                .excludeHumans(true)
                                .excludeInternal(true)
                                .withCustomAttributes(true)
                                .customAttributes(Map.of("key", "value"))
                                .skipLdap(true)
                                .auditors(true)
                                .build())
                .auditors(null);

        final GitLabUsersListFilter built = builder.build();

        assertThat(built.auditors()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersListFilter value = GitLabUsersListFilterBuilder.builder()
                .username("username")
                .externUid("extern_uid")
                .publicEmail("public_email")
                .provider("provider")
                .search("search")
                .active(true)
                .humans(true)
                .external(true)
                .blocked(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .withoutProjects(true)
                .withoutProjectBots(true)
                .admins(true)
                .twoFactor("two_factor")
                .excludeActive(true)
                .excludeExternal(true)
                .excludeHumans(true)
                .excludeInternal(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .skipLdap(true)
                .auditors(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.externUid()).isEqualTo("extern_uid");
            softly.assertThat(value.publicEmail()).isEqualTo("public_email");
            softly.assertThat(value.provider()).isEqualTo("provider");
            softly.assertThat(value.search()).isEqualTo("search");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.humans()).isEqualTo(true);
            softly.assertThat(value.external()).isEqualTo(true);
            softly.assertThat(value.blocked()).isEqualTo(true);
            softly.assertThat(value.createdAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdBefore()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.withoutProjects()).isEqualTo(true);
            softly.assertThat(value.withoutProjectBots()).isEqualTo(true);
            softly.assertThat(value.admins()).isEqualTo(true);
            softly.assertThat(value.twoFactor()).isEqualTo("two_factor");
            softly.assertThat(value.excludeActive()).isEqualTo(true);
            softly.assertThat(value.excludeExternal()).isEqualTo(true);
            softly.assertThat(value.excludeHumans()).isEqualTo(true);
            softly.assertThat(value.excludeInternal()).isEqualTo(true);
            softly.assertThat(value.withCustomAttributes()).isEqualTo(true);
            softly.assertThat(value.customAttributes()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.skipLdap()).isEqualTo(true);
            softly.assertThat(value.auditors()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersListFilter original = GitLabUsersListFilterBuilder.builder()
                .username("username")
                .externUid("extern_uid")
                .publicEmail("public_email")
                .provider("provider")
                .search("search")
                .active(true)
                .humans(true)
                .external(true)
                .blocked(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .withoutProjects(true)
                .withoutProjectBots(true)
                .admins(true)
                .twoFactor("two_factor")
                .excludeActive(true)
                .excludeExternal(true)
                .excludeHumans(true)
                .excludeInternal(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .skipLdap(true)
                .auditors(true)
                .build();

        final GitLabUsersListFilter rebuilt =
                GitLabUsersListFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenCustomAttributesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabUsersListFilter built = GitLabUsersListFilterBuilder.builder(GitLabUsersListFilterBuilder.builder()
                        .username("username")
                        .externUid("extern_uid")
                        .publicEmail("public_email")
                        .provider("provider")
                        .search("search")
                        .active(true)
                        .humans(true)
                        .external(true)
                        .blocked(true)
                        .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                        .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                        .withoutProjects(true)
                        .withoutProjectBots(true)
                        .admins(true)
                        .twoFactor("two_factor")
                        .excludeActive(true)
                        .excludeExternal(true)
                        .excludeHumans(true)
                        .excludeInternal(true)
                        .withCustomAttributes(true)
                        .customAttributes(Map.of("key", "value"))
                        .skipLdap(true)
                        .auditors(true)
                        .build())
                .customAttributes(source)
                .build();
        source.clear();

        assertThat(built.customAttributes()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersListFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "username",
                        "externUid",
                        "publicEmail",
                        "provider",
                        "search",
                        "active",
                        "humans",
                        "external",
                        "blocked",
                        "createdAfter",
                        "createdBefore",
                        "withoutProjects",
                        "withoutProjectBots",
                        "admins",
                        "twoFactor",
                        "excludeActive",
                        "excludeExternal",
                        "excludeHumans",
                        "excludeInternal",
                        "withCustomAttributes",
                        "customAttributes",
                        "skipLdap",
                        "auditors");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabUsersListFilter empty = GitLabUsersListFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabUsersListFilter filter = GitLabUsersListFilterBuilder.builder()
                .username("username")
                .externUid("extern_uid")
                .publicEmail("public_email")
                .provider("provider")
                .search("search")
                .active(true)
                .humans(true)
                .external(true)
                .blocked(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .withoutProjects(true)
                .withoutProjectBots(true)
                .admins(true)
                .twoFactor("two_factor")
                .excludeActive(true)
                .excludeExternal(true)
                .excludeHumans(true)
                .excludeInternal(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .skipLdap(true)
                .auditors(true)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("username", "username"),
                        Map.entry("extern_uid", "extern_uid"),
                        Map.entry("public_email", "public_email"),
                        Map.entry("provider", "provider"),
                        Map.entry("search", "search"),
                        Map.entry("active", "true"),
                        Map.entry("humans", "true"),
                        Map.entry("external", "true"),
                        Map.entry("blocked", "true"),
                        Map.entry("created_after", "2026-01-01T00:00:00Z"),
                        Map.entry("created_before", "2026-01-01T00:00:00Z"),
                        Map.entry("without_projects", "true"),
                        Map.entry("without_project_bots", "true"),
                        Map.entry("admins", "true"),
                        Map.entry("two_factor", "two_factor"),
                        Map.entry("exclude_active", "true"),
                        Map.entry("exclude_external", "true"),
                        Map.entry("exclude_humans", "true"),
                        Map.entry("exclude_internal", "true"),
                        Map.entry("with_custom_attributes", "true"),
                        Map.entry("custom_attributes[key]", "value"),
                        Map.entry("skip_ldap", "true"),
                        Map.entry("auditors", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabUsersListFilter filter =
                GitLabUsersListFilterBuilder.builder().username("username").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("username", "username"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabUsersListFilter filter = GitLabUsersListFilterBuilder.builder()
                .username("username")
                .externUid("extern_uid")
                .publicEmail("public_email")
                .provider("provider")
                .search("search")
                .active(true)
                .humans(true)
                .external(true)
                .blocked(true)
                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                .withoutProjects(true)
                .withoutProjectBots(true)
                .admins(true)
                .twoFactor("two_factor")
                .excludeActive(true)
                .excludeExternal(true)
                .excludeHumans(true)
                .excludeInternal(true)
                .withCustomAttributes(true)
                .customAttributes(Map.of("key", "value"))
                .skipLdap(true)
                .auditors(true)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
