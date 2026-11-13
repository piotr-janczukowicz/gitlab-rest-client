package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDiscussionsApiTest {

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabDiscussionsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void accessors_shouldReturnTheSameApi_whenAskedTwice() throws Exception {
        final GitLabCaller caller = GitLabApiTestClients.caller(HttpTransportMocks.mock());
        final GitLabDiscussionsApi target = new GitLabDiscussionsApi(caller);

        assertSoftly(softly -> {
            softly.assertThat(target.group()).isSameAs(target.group());
            softly.assertThat(target.project()).isSameAs(target.project());
        });
    }
}
