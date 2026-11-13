package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsRotateManageResourceAccessTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabGroupGroupsRotateManageResourceAccessTokenPayloadBuilder builder =
                GitLabGroupGroupsRotateManageResourceAccessTokenPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload())
                        .expiresAt(null);

        final GitLabGroupGroupsRotateManageResourceAccessTokenPayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsRotateManageResourceAccessTokenPayload value =
                GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload();

        assertThat(value.expiresAt()).isEqualTo(LocalDate.parse("2026-01-01"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsRotateManageResourceAccessTokenPayload original =
                GroupsCatalogFixtures.groupGroupsRotateManageResourceAccessTokenPayload();

        final GitLabGroupGroupsRotateManageResourceAccessTokenPayload rebuilt =
                GitLabGroupGroupsRotateManageResourceAccessTokenPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsRotateManageResourceAccessTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("expiresAt");
    }
}
