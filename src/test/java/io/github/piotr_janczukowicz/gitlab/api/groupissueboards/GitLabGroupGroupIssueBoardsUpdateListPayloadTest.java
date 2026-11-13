package io.github.piotr_janczukowicz.gitlab.api.groupissueboards;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIssueBoardsUpdateListPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabGroupGroupIssueBoardsUpdateListPayloadBuilder builder =
                GitLabGroupGroupIssueBoardsUpdateListPayloadBuilder.builder(
                                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdateListPayload())
                        .position(null);

        final GitLabGroupGroupIssueBoardsUpdateListPayload built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIssueBoardsUpdateListPayload value =
                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdateListPayload();

        assertThat(value.position()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIssueBoardsUpdateListPayload original =
                GroupissueboardsCatalogFixtures.groupGroupIssueBoardsUpdateListPayload();

        final GitLabGroupGroupIssueBoardsUpdateListPayload rebuilt =
                GitLabGroupGroupIssueBoardsUpdateListPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIssueBoardsUpdateListPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("position");
    }
}
