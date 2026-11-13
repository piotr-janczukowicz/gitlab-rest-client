package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsTransferPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabGroupGroupsTransferPayloadBuilder builder = GitLabGroupGroupsTransferPayloadBuilder.builder(
                        GroupsCatalogFixtures.groupGroupsTransferPayload())
                .groupId(null);

        final GitLabGroupGroupsTransferPayload built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsTransferPayload value = GroupsCatalogFixtures.groupGroupsTransferPayload();

        assertThat(value.groupId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsTransferPayload original = GroupsCatalogFixtures.groupGroupsTransferPayload();

        final GitLabGroupGroupsTransferPayload rebuilt =
                GitLabGroupGroupsTransferPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsTransferPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("groupId");
    }
}
