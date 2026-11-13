package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsRotateManagePersonalAccessTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupGroupsRotateManagePersonalAccessTokenPayloadBuilder builder =
                GitLabGroupGroupsRotateManagePersonalAccessTokenPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload())
                        .expiresAt(null);

        final GitLabGroupGroupsRotateManagePersonalAccessTokenPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsRotateManagePersonalAccessTokenPayload value =
                GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload();

        assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsRotateManagePersonalAccessTokenPayload original =
                GroupsCatalogFixtures.groupGroupsRotateManagePersonalAccessTokenPayload();

        final GitLabGroupGroupsRotateManagePersonalAccessTokenPayload rebuilt =
                GitLabGroupGroupsRotateManagePersonalAccessTokenPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsRotateManagePersonalAccessTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expiresAt");
    }
}
