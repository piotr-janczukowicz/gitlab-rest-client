package io.github.piotr_janczukowicz.gitlab.api.alertmanagementalerts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of project alert management alerts. */
public final class GitLabProjectAlertManagementAlertsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final PathTemplate AUTHORIZE =
            PathTemplate.of("/projects/{id}/alert_management_alerts/{alert_iid}/metric_images/authorize");
    private static final PathTemplate LIST =
            PathTemplate.of("/projects/{id}/alert_management_alerts/{alert_iid}/metric_images");
    private static final PathTemplate UPDATE =
            PathTemplate.of("/projects/{id}/alert_management_alerts/{alert_iid}/metric_images/{metric_image_id}");
    private static final JsonType<List<GitLabMetricImage>> METRIC_IMAGE_LIST_TYPE =
            JsonTypes.listOf(GitLabMetricImage.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectAlertManagementAlertsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Authorize ({@code POST /projects/{id}/alert_management_alerts/{alert_iid}/metric_images/authorize}).
     *
     * @param id the id
     * @param alertIid the alert iid
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void authorize(final String id, final long alertIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(post(AUTHORIZE, id, alertIid));
    }

    /**
     * List ({@code GET /projects/{id}/alert_management_alerts/{alert_iid}/metric_images}).
     *
     * @param id the id
     * @param alertIid the alert iid
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabMetricImage> list(final String id, final long alertIid) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id, alertIid), METRIC_IMAGE_LIST_TYPE);
    }

    /**
     * Create ({@code POST /projects/{id}/alert_management_alerts/{alert_iid}/metric_images}).
     *
     * @param id the id
     * @param alertIid the alert iid
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMetricImage create(final String id, final long alertIid, final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(post(LIST, id, alertIid), form), GitLabMetricImage.class);
    }

    /**
     * Update ({@code PUT /projects/{id}/alert_management_alerts/{alert_iid}/metric_images/{metric_image_id}}).
     *
     * @param id the id
     * @param alertIid the alert iid
     * @param metricImageId the metric image id
     * @param form the form to send
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabMetricImage update(
            final String id, final long alertIid, final long metricImageId, final MultipartFormData form)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(put(UPDATE, id, alertIid, metricImageId), form), GitLabMetricImage.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/alert_management_alerts/{alert_iid}/metric_images/{metric_image_id}}).
     *
     * @param id the id
     * @param alertIid the alert iid
     * @param metricImageId the metric image id
     * @return the deleted resource, or empty when GitLab answers with no body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabMetricImage> delete(final String id, final long alertIid, final long metricImageId)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetchOptional(delete(UPDATE, id, alertIid, metricImageId), GitLabMetricImage.class);
    }
}
