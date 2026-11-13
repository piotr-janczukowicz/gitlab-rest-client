package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAccessRequestsApprovePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectAccessRequestsApprovePayloadBuilder builder =
                GitLabProjectAccessRequestsApprovePayloadBuilder.builder(
                                AccessrequestsCatalogFixtures.projectAccessRequestsApprovePayload())
                        .accessLevel(null);

        final GitLabProjectAccessRequestsApprovePayload built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAccessRequestsApprovePayload value =
                AccessrequestsCatalogFixtures.projectAccessRequestsApprovePayload();

        assertThat(value.accessLevel()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAccessRequestsApprovePayload original =
                AccessrequestsCatalogFixtures.projectAccessRequestsApprovePayload();

        final GitLabProjectAccessRequestsApprovePayload rebuilt =
                GitLabProjectAccessRequestsApprovePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectAccessRequestsApprovePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel");
    }
}
