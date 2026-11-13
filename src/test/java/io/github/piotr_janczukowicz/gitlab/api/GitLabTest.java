package io.github.piotr_janczukowicz.gitlab.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClients;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.client.authentication.AuthenticationProviders;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTest {

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLab(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void accessors_shouldReturnTheSameApi_whenAskedTwice() throws Exception {
        final GitLabCaller caller = GitLabApiTestClients.caller(HttpTransportMocks.mock());
        final GitLab target = new GitLab(caller);

        assertSoftly(softly -> {
            softly.assertThat(target.accessrequests()).isSameAs(target.accessrequests());
            softly.assertThat(target.accesstokens()).isSameAs(target.accesstokens());
            softly.assertThat(target.activecontext()).isSameAs(target.activecontext());
            softly.assertThat(target.advancedsearchrollout()).isSameAs(target.advancedsearchrollout());
            softly.assertThat(target.agents()).isSameAs(target.agents());
            softly.assertThat(target.alertmanagementalerts()).isSameAs(target.alertmanagementalerts());
            softly.assertThat(target.analytics()).isSameAs(target.analytics());
            softly.assertThat(target.appearance()).isSameAs(target.appearance());
            softly.assertThat(target.applications()).isSameAs(target.applications());
            softly.assertThat(target.attestations()).isSameAs(target.attestations());
            softly.assertThat(target.auditevents()).isSameAs(target.auditevents());
            softly.assertThat(target.authn()).isSameAs(target.authn());
            softly.assertThat(target.avatar()).isSameAs(target.avatar());
            softly.assertThat(target.batchedbackgroundmigrations()).isSameAs(target.batchedbackgroundmigrations());
            softly.assertThat(target.branches()).isSameAs(target.branches());
            softly.assertThat(target.broadcastmessages()).isSameAs(target.broadcastmessages());
            softly.assertThat(target.clusterdiscoverycertificatebaseddeprecated())
                    .isSameAs(target.clusterdiscoverycertificatebaseddeprecated());
            softly.assertThat(target.codereviewanalytics()).isSameAs(target.codereviewanalytics());
            softly.assertThat(target.codesearch()).isSameAs(target.codesearch());
            softly.assertThat(target.codesnippets()).isSameAs(target.codesnippets());
            softly.assertThat(target.codesuggestions()).isSameAs(target.codesuggestions());
            softly.assertThat(target.commits()).isSameAs(target.commits());
            softly.assertThat(target.complianceandpolicysettings()).isSameAs(target.complianceandpolicysettings());
            softly.assertThat(target.composerdistributions()).isSameAs(target.composerdistributions());
            softly.assertThat(target.conanv1distributions()).isSameAs(target.conanv1distributions());
            softly.assertThat(target.conanv2distributions()).isSameAs(target.conanv2distributions());
            softly.assertThat(target.containerregistry()).isSameAs(target.containerregistry());
            softly.assertThat(target.containerregistryprotectiontagrules())
                    .isSameAs(target.containerregistryprotectiontagrules());
            softly.assertThat(target.customattributes()).isSameAs(target.customattributes());
            softly.assertThat(target.databasedictionary()).isSameAs(target.databasedictionary());
            softly.assertThat(target.databasemigrations()).isSameAs(target.databasemigrations());
            softly.assertThat(target.datamanagement()).isSameAs(target.datamanagement());
            softly.assertThat(target.debiandistributions()).isSameAs(target.debiandistributions());
            softly.assertThat(target.debianpackages()).isSameAs(target.debianpackages());
            softly.assertThat(target.dependencies()).isSameAs(target.dependencies());
            softly.assertThat(target.dependencylistexports()).isSameAs(target.dependencylistexports());
            softly.assertThat(target.dependencymanagement()).isSameAs(target.dependencymanagement());
            softly.assertThat(target.dependencyproxy()).isSameAs(target.dependencyproxy());
            softly.assertThat(target.deploykeys()).isSameAs(target.deploykeys());
            softly.assertThat(target.deployments()).isSameAs(target.deployments());
            softly.assertThat(target.deploytokens()).isSameAs(target.deploytokens());
            softly.assertThat(target.devopsresearchandassessmentdorametrics())
                    .isSameAs(target.devopsresearchandassessmentdorametrics());
            softly.assertThat(target.discussions()).isSameAs(target.discussions());
            softly.assertThat(target.dockerfiletemplates()).isSameAs(target.dockerfiletemplates());
            softly.assertThat(target.draftnotes()).isSameAs(target.draftnotes());
            softly.assertThat(target.emojireactions()).isSameAs(target.emojireactions());
            softly.assertThat(target.environments()).isSameAs(target.environments());
            softly.assertThat(target.epicissues()).isSameAs(target.epicissues());
            softly.assertThat(target.epiclinks()).isSameAs(target.epiclinks());
            softly.assertThat(target.epics()).isSameAs(target.epics());
            softly.assertThat(target.errortracking()).isSameAs(target.errortracking());
            softly.assertThat(target.events()).isSameAs(target.events());
            softly.assertThat(target.experiments()).isSameAs(target.experiments());
            softly.assertThat(target.externalstatuschecks()).isSameAs(target.externalstatuschecks());
            softly.assertThat(target.featureflags()).isSameAs(target.featureflags());
            softly.assertThat(target.featureflaguserlists()).isSameAs(target.featureflaguserlists());
            softly.assertThat(target.freezeperiods()).isSameAs(target.freezeperiods());
            softly.assertThat(target.geo()).isSameAs(target.geo());
            softly.assertThat(target.geonodes()).isSameAs(target.geonodes());
            softly.assertThat(target.geosites()).isSameAs(target.geosites());
            softly.assertThat(target.gitignoretemplates()).isSameAs(target.gitignoretemplates());
            softly.assertThat(target.gitlabcicdyamltemplates()).isSameAs(target.gitlabcicdyamltemplates());
            softly.assertThat(target.gitlabduo()).isSameAs(target.gitlabduo());
            softly.assertThat(target.gitlabduoagentplatformflows()).isSameAs(target.gitlabduoagentplatformflows());
            softly.assertThat(target.gitlabduochatcompletions()).isSameAs(target.gitlabduochatcompletions());
            softly.assertThat(target.glql()).isSameAs(target.glql());
            softly.assertThat(target.googlecloudintegration()).isSameAs(target.googlecloudintegration());
            softly.assertThat(target.goproxy()).isSameAs(target.goproxy());
            softly.assertThat(target.groupandprojectmigrationbydirecttransfer())
                    .isSameAs(target.groupandprojectmigrationbydirecttransfer());
            softly.assertThat(target.groupbadges()).isSameAs(target.groupbadges());
            softly.assertThat(target.groupenterpriseusers()).isSameAs(target.groupenterpriseusers());
            softly.assertThat(target.groupepicboards()).isSameAs(target.groupepicboards());
            softly.assertThat(target.groupimportandexport()).isSameAs(target.groupimportandexport());
            softly.assertThat(target.groupintegrations()).isSameAs(target.groupintegrations());
            softly.assertThat(target.groupissueboards()).isSameAs(target.groupissueboards());
            softly.assertThat(target.groupiterations()).isSameAs(target.groupiterations());
            softly.assertThat(target.grouplabels()).isSameAs(target.grouplabels());
            softly.assertThat(target.grouplevelprotectedbranches()).isSameAs(target.grouplevelprotectedbranches());
            softly.assertThat(target.grouplevelprotectedenvironments())
                    .isSameAs(target.grouplevelprotectedenvironments());
            softly.assertThat(target.grouplevelvariables()).isSameAs(target.grouplevelvariables());
            softly.assertThat(target.groupmarkdownuploads()).isSameAs(target.groupmarkdownuploads());
            softly.assertThat(target.groupmilestones()).isSameAs(target.groupmilestones());
            softly.assertThat(target.groupplaceholderreassignments()).isSameAs(target.groupplaceholderreassignments());
            softly.assertThat(target.grouppushrules()).isSameAs(target.grouppushrules());
            softly.assertThat(target.groupreleases()).isSameAs(target.groupreleases());
            softly.assertThat(target.grouprepositorystoragemoves()).isSameAs(target.grouprepositorystoragemoves());
            softly.assertThat(target.groups()).isSameAs(target.groups());
            softly.assertThat(target.groupsecuritysettings()).isSameAs(target.groupsecuritysettings());
            softly.assertThat(target.groupsshcertificates()).isSameAs(target.groupsshcertificates());
            softly.assertThat(target.groupwebhooks()).isSameAs(target.groupwebhooks());
            softly.assertThat(target.groupwikis()).isSameAs(target.groupwikis());
            softly.assertThat(target.importrepositoryfrombitbucketserver())
                    .isSameAs(target.importrepositoryfrombitbucketserver());
            softly.assertThat(target.importrepositoryfromgithub()).isSameAs(target.importrepositoryfromgithub());
            softly.assertThat(target.instanceclusters()).isSameAs(target.instanceclusters());
            softly.assertThat(target.instancelevelcicdvariables()).isSameAs(target.instancelevelcicdvariables());
            softly.assertThat(target.integrations()).isSameAs(target.integrations());
            softly.assertThat(target.invitations()).isSameAs(target.invitations());
            softly.assertThat(target.issueboards()).isSameAs(target.issueboards());
            softly.assertThat(target.issuelinks()).isSameAs(target.issuelinks());
            softly.assertThat(target.issues()).isSameAs(target.issues());
            softly.assertThat(target.issuesstatistics()).isSameAs(target.issuesstatistics());
            softly.assertThat(target.iterations()).isSameAs(target.iterations());
            softly.assertThat(target.jiraconnectsubscriptions()).isSameAs(target.jiraconnectsubscriptions());
            softly.assertThat(target.jiraforgeinstallation()).isSameAs(target.jiraforgeinstallation());
            softly.assertThat(target.jiraforgesubscriptions()).isSameAs(target.jiraforgesubscriptions());
            softly.assertThat(target.jiraforgeuserdelegation()).isSameAs(target.jiraforgeuserdelegation());
            softly.assertThat(target.jobs()).isSameAs(target.jobs());
            softly.assertThat(target.jobsartifacts()).isSameAs(target.jobsartifacts());
            softly.assertThat(target.keys()).isSameAs(target.keys());
            softly.assertThat(target.knowledgegraph()).isSameAs(target.knowledgegraph());
            softly.assertThat(target.labels()).isSameAs(target.labels());
            softly.assertThat(target.ldap()).isSameAs(target.ldap());
            softly.assertThat(target.ldapgrouplinks()).isSameAs(target.ldapgrouplinks());
            softly.assertThat(target.license()).isSameAs(target.license());
            softly.assertThat(target.linkedepics()).isSameAs(target.linkedepics());
            softly.assertThat(target.markdown()).isSameAs(target.markdown());
            softly.assertThat(target.markdownuploads()).isSameAs(target.markdownuploads());
            softly.assertThat(target.mavenrepository()).isSameAs(target.mavenrepository());
            softly.assertThat(target.memberroles()).isSameAs(target.memberroles());
            softly.assertThat(target.members()).isSameAs(target.members());
            softly.assertThat(target.mergerequestapprovals()).isSameAs(target.mergerequestapprovals());
            softly.assertThat(target.mergerequestapprovalsettings()).isSameAs(target.mergerequestapprovalsettings());
            softly.assertThat(target.mergerequestcontextcommits()).isSameAs(target.mergerequestcontextcommits());
            softly.assertThat(target.mergerequests()).isSameAs(target.mergerequests());
            softly.assertThat(target.mergetrains()).isSameAs(target.mergetrains());
            softly.assertThat(target.metadata()).isSameAs(target.metadata());
            softly.assertThat(target.migrations()).isSameAs(target.migrations());
            softly.assertThat(target.mobilepushsubscriptions()).isSameAs(target.mobilepushsubscriptions());
            softly.assertThat(target.modelregistry()).isSameAs(target.modelregistry());
            softly.assertThat(target.namespaces()).isSameAs(target.namespaces());
            softly.assertThat(target.notes()).isSameAs(target.notes());
            softly.assertThat(target.notificationsettings()).isSameAs(target.notificationsettings());
            softly.assertThat(target.npmrepository()).isSameAs(target.npmrepository());
            softly.assertThat(target.nugetpackages()).isSameAs(target.nugetpackages());
            softly.assertThat(target.offlinetransfers()).isSameAs(target.offlinetransfers());
            softly.assertThat(target.opensourcelicensetemplates()).isSameAs(target.opensourcelicensetemplates());
            softly.assertThat(target.orbit()).isSameAs(target.orbit());
            softly.assertThat(target.organizations()).isSameAs(target.organizations());
            softly.assertThat(target.packages()).isSameAs(target.packages());
            softly.assertThat(target.pagesdomains()).isSameAs(target.pagesdomains());
            softly.assertThat(target.pagessettings()).isSameAs(target.pagessettings());
            softly.assertThat(target.personalaccesstokens()).isSameAs(target.personalaccesstokens());
            softly.assertThat(target.pipelines()).isSameAs(target.pipelines());
            softly.assertThat(target.pipelineschedules()).isSameAs(target.pipelineschedules());
            softly.assertThat(target.pipelinetriggers()).isSameAs(target.pipelinetriggers());
            softly.assertThat(target.planlimits()).isSameAs(target.planlimits());
            softly.assertThat(target.projectaliases()).isSameAs(target.projectaliases());
            softly.assertThat(target.projectbadges()).isSameAs(target.projectbadges());
            softly.assertThat(target.projectcicdjobtokenscope()).isSameAs(target.projectcicdjobtokenscope());
            softly.assertThat(target.projectclusters()).isSameAs(target.projectclusters());
            softly.assertThat(target.projectforks()).isSameAs(target.projectforks());
            softly.assertThat(target.projectimport()).isSameAs(target.projectimport());
            softly.assertThat(target.projectimportexport()).isSameAs(target.projectimportexport());
            softly.assertThat(target.projectlevelsecurefiles()).isSameAs(target.projectlevelsecurefiles());
            softly.assertThat(target.projectlevelvariables()).isSameAs(target.projectlevelvariables());
            softly.assertThat(target.projectmilestones()).isSameAs(target.projectmilestones());
            softly.assertThat(target.projectpushrules()).isSameAs(target.projectpushrules());
            softly.assertThat(target.projectrelationsexport()).isSameAs(target.projectrelationsexport());
            softly.assertThat(target.projectrepositorystoragemoves()).isSameAs(target.projectrepositorystoragemoves());
            softly.assertThat(target.projects()).isSameAs(target.projects());
            softly.assertThat(target.projectsecuritysettings()).isSameAs(target.projectsecuritysettings());
            softly.assertThat(target.projectsnippets()).isSameAs(target.projectsnippets());
            softly.assertThat(target.projectstarring()).isSameAs(target.projectstarring());
            softly.assertThat(target.projectstatistics()).isSameAs(target.projectstatistics());
            softly.assertThat(target.projecttemplates()).isSameAs(target.projecttemplates());
            softly.assertThat(target.projectvulnerabilities()).isSameAs(target.projectvulnerabilities());
            softly.assertThat(target.projectwebhooks()).isSameAs(target.projectwebhooks());
            softly.assertThat(target.projectwikis()).isSameAs(target.projectwikis());
            softly.assertThat(target.protectedbranches()).isSameAs(target.protectedbranches());
            softly.assertThat(target.protectedcontainerregistry()).isSameAs(target.protectedcontainerregistry());
            softly.assertThat(target.protectedenvironments()).isSameAs(target.protectedenvironments());
            softly.assertThat(target.protectedpackages()).isSameAs(target.protectedpackages());
            softly.assertThat(target.protectedtags()).isSameAs(target.protectedtags());
            softly.assertThat(target.pullmirroring()).isSameAs(target.pullmirroring());
            softly.assertThat(target.pypipackages()).isSameAs(target.pypipackages());
            softly.assertThat(target.releaselinks()).isSameAs(target.releaselinks());
            softly.assertThat(target.releases()).isSameAs(target.releases());
            softly.assertThat(target.remotemirrors()).isSameAs(target.remotemirrors());
            softly.assertThat(target.repositories()).isSameAs(target.repositories());
            softly.assertThat(target.repositoryfiles()).isSameAs(target.repositoryfiles());
            softly.assertThat(target.repositorysubmodules()).isSameAs(target.repositorysubmodules());
            softly.assertThat(target.resourcegroup()).isSameAs(target.resourcegroup());
            softly.assertThat(target.resourceiterationevents()).isSameAs(target.resourceiterationevents());
            softly.assertThat(target.resourcelabelevents()).isSameAs(target.resourcelabelevents());
            softly.assertThat(target.resourcemilestoneevents()).isSameAs(target.resourcemilestoneevents());
            softly.assertThat(target.resourcestateevents()).isSameAs(target.resourcestateevents());
            softly.assertThat(target.resourceweightevents()).isSameAs(target.resourceweightevents());
            softly.assertThat(target.rollouts()).isSameAs(target.rollouts());
            softly.assertThat(target.rubygems()).isSameAs(target.rubygems());
            softly.assertThat(target.runnercontrollers()).isSameAs(target.runnercontrollers());
            softly.assertThat(target.runnercontrollertokens()).isSameAs(target.runnercontrollertokens());
            softly.assertThat(target.runners()).isSameAs(target.runners());
            softly.assertThat(target.saml()).isSameAs(target.saml());
            softly.assertThat(target.scim()).isSameAs(target.scim());
            softly.assertThat(target.search()).isSameAs(target.search());
            softly.assertThat(target.searchadmin()).isSameAs(target.searchadmin());
            softly.assertThat(target.serviceaccounts()).isSameAs(target.serviceaccounts());
            softly.assertThat(target.servicedata()).isSameAs(target.servicedata());
            softly.assertThat(target.settings()).isSameAs(target.settings());
            softly.assertThat(target.sidekiq()).isSameAs(target.sidekiq());
            softly.assertThat(target.sidekiqmetrics()).isSameAs(target.sidekiqmetrics());
            softly.assertThat(target.sidekiqqueuesadministration()).isSameAs(target.sidekiqqueuesadministration());
            softly.assertThat(target.snippetrepositorystoragemoves()).isSameAs(target.snippetrepositorystoragemoves());
            softly.assertThat(target.softwarecompositionanalysis()).isSameAs(target.softwarecompositionanalysis());
            softly.assertThat(target.statistics()).isSameAs(target.statistics());
            softly.assertThat(target.suggestions()).isSameAs(target.suggestions());
            softly.assertThat(target.systemhooks()).isSameAs(target.systemhooks());
            softly.assertThat(target.tags()).isSameAs(target.tags());
            softly.assertThat(target.terraformmodules()).isSameAs(target.terraformmodules());
            softly.assertThat(target.terraformstate()).isSameAs(target.terraformstate());
            softly.assertThat(target.todos()).isSameAs(target.todos());
            softly.assertThat(target.tokenexchange()).isSameAs(target.tokenexchange());
            softly.assertThat(target.topics()).isSameAs(target.topics());
            softly.assertThat(target.unleash()).isSameAs(target.unleash());
            softly.assertThat(target.userapplications()).isSameAs(target.userapplications());
            softly.assertThat(target.useremailaddresses()).isSameAs(target.useremailaddresses());
            softly.assertThat(target.userfollowandunfollow()).isSameAs(target.userfollowandunfollow());
            softly.assertThat(target.usermoderation()).isSameAs(target.usermoderation());
            softly.assertThat(target.users()).isSameAs(target.users());
            softly.assertThat(target.usersshandgpgkeys()).isSameAs(target.usersshandgpgkeys());
            softly.assertThat(target.usertokens()).isSameAs(target.usertokens());
            softly.assertThat(target.validategitlabciymlfile()).isSameAs(target.validategitlabciymlfile());
            softly.assertThat(target.vscode()).isSameAs(target.vscode());
            softly.assertThat(target.vulnerabilities()).isSameAs(target.vulnerabilities());
            softly.assertThat(target.vulnerabilityfindings()).isSameAs(target.vulnerabilityfindings());
            softly.assertThat(target.webcommits()).isSameAs(target.webcommits());
        });
    }

    @Test
    void of_shouldCreateTheFacade_whenAClientIsGiven() throws Exception {
        final GitLabClient client = GitLabClients.create(AuthenticationProviders.none(), "gitlab-test/1.0");

        final GitLab created = GitLab.of(client);
        client.close();

        assertThat(created).isNotNull();
    }
}
