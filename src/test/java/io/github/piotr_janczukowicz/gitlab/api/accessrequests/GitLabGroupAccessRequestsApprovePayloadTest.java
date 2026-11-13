package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupAccessRequestsApprovePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupAccessRequestsApprovePayloadBuilder builder =
                GitLabGroupAccessRequestsApprovePayloadBuilder.builder(
                                AccessrequestsCatalogFixtures.groupAccessRequestsApprovePayload())
                        .accessLevel(null);

        final GitLabGroupAccessRequestsApprovePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAccessRequestsApprovePayload value =
                AccessrequestsCatalogFixtures.groupAccessRequestsApprovePayload();

        assertThat(value.accessLevel()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAccessRequestsApprovePayload original =
                AccessrequestsCatalogFixtures.groupAccessRequestsApprovePayload();

        final GitLabGroupAccessRequestsApprovePayload rebuilt =
                GitLabGroupAccessRequestsApprovePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupAccessRequestsApprovePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}
