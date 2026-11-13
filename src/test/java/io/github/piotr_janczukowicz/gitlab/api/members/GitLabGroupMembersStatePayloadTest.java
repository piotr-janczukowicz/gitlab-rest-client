package io.github.piotr_janczukowicz.gitlab.api.members;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupMembersStatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenStateIsNull() {
        final GitLabGroupMembersStatePayloadBuilder builder = GitLabGroupMembersStatePayloadBuilder.builder(
                        MembersCatalogFixtures.groupMembersStatePayload())
                .state(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("state");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupMembersStatePayload value = MembersCatalogFixtures.groupMembersStatePayload();

        assertThat(value.state()).isEqualTo(GitLabGroupMembersStateState.AWAITING);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupMembersStatePayload original = MembersCatalogFixtures.groupMembersStatePayload();

        final GitLabGroupMembersStatePayload rebuilt =
                GitLabGroupMembersStatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupMembersStatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("state");
    }
}
