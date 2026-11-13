package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsUpdateSamlPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExternUidIsNullable() {
        final GitLabGroupGroupsUpdateSamlPayloadBuilder builder = GitLabGroupGroupsUpdateSamlPayloadBuilder.builder(
                        GroupsCatalogFixtures.groupGroupsUpdateSamlPayload())
                .externUid(null);

        final GitLabGroupGroupsUpdateSamlPayload built = builder.build();

        assertThat(built.externUid()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsUpdateSamlPayload value = GroupsCatalogFixtures.groupGroupsUpdateSamlPayload();

        assertThat(value.externUid()).isEqualTo("extern_uid");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsUpdateSamlPayload original = GroupsCatalogFixtures.groupGroupsUpdateSamlPayload();

        final GitLabGroupGroupsUpdateSamlPayload rebuilt =
                GitLabGroupGroupsUpdateSamlPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsUpdateSamlPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("externUid");
    }
}
