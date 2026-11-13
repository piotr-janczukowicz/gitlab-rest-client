package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsTransferToOrganizationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIdIsNullable() {
        final GitLabGroupGroupsTransferToOrganizationPayloadBuilder builder =
                GitLabGroupGroupsTransferToOrganizationPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsTransferToOrganizationPayload())
                        .organizationId(null);

        final GitLabGroupGroupsTransferToOrganizationPayload built = builder.build();

        assertThat(built.organizationId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsTransferToOrganizationPayload value =
                GroupsCatalogFixtures.groupGroupsTransferToOrganizationPayload();

        assertThat(value.organizationId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsTransferToOrganizationPayload original =
                GroupsCatalogFixtures.groupGroupsTransferToOrganizationPayload();

        final GitLabGroupGroupsTransferToOrganizationPayload rebuilt =
                GitLabGroupGroupsTransferToOrganizationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsTransferToOrganizationPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("organizationId");
    }
}
