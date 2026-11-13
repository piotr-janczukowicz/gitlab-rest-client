package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsUpdateScimPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExternUidIsNullable() {
        final GitLabGroupGroupsUpdateScimPayloadBuilder builder = GitLabGroupGroupsUpdateScimPayloadBuilder.builder(
                        GroupsCatalogFixtures.groupGroupsUpdateScimPayload())
                .externUid(null);

        final GitLabGroupGroupsUpdateScimPayload built = builder.build();

        assertThat(built.externUid()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsUpdateScimPayload value = GroupsCatalogFixtures.groupGroupsUpdateScimPayload();

        assertThat(value.externUid()).isEqualTo("extern_uid");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsUpdateScimPayload original = GroupsCatalogFixtures.groupGroupsUpdateScimPayload();

        final GitLabGroupGroupsUpdateScimPayload rebuilt =
                GitLabGroupGroupsUpdateScimPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsUpdateScimPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("externUid");
    }
}
