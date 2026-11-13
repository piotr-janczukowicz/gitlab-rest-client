package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrganizationsCreateTransferUserPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdsIsNullable() {
        final GitLabOrganizationsCreateTransferUserPayloadBuilder builder =
                GitLabOrganizationsCreateTransferUserPayloadBuilder.builder(
                                OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload())
                        .userIds(null);

        final GitLabOrganizationsCreateTransferUserPayload built = builder.build();

        assertThat(built.userIds()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrganizationsCreateTransferUserPayload value =
                OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload();

        assertThat(value.userIds()).isEqualTo(List.of(1L));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrganizationsCreateTransferUserPayload original =
                OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload();

        final GitLabOrganizationsCreateTransferUserPayload rebuilt =
                GitLabOrganizationsCreateTransferUserPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenUserIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabOrganizationsCreateTransferUserPayload built =
                GitLabOrganizationsCreateTransferUserPayloadBuilder.builder(
                                OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload())
                        .userIds(source)
                        .build();
        source.clear();

        assertThat(built.userIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenUserIdsIsRead() {
        final GitLabOrganizationsCreateTransferUserPayload built =
                OrganizationsCatalogFixtures.organizationsCreateTransferUserPayload();
        final List<Long> values = built.userIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrganizationsCreateTransferUserPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("userIds");
    }
}
