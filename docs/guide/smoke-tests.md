# Live smoke tests

Previous: [Good to know](good-to-know.md) · [Guide index](README.md)

The smoke tests (`src/test/java/.../gitlab/smoke`, `*SmokeIT`) call a real GitLab instance: they read the user and the
project, round-trip labels, issues, a branch and a file, page with `per_page=1`, and check the 404 and 401 paths. They are not
part of the build and skip themselves when the variables are not set.

| Variable | Meaning |
|---|---|
| `SMOKE_GITLAB_TOKEN` | A personal access token with the `api` scope of a user who owns the sandbox project |
| `SMOKE_GITLAB_PROJECT` | The path of a sandbox project, `group/name`; the path must contain `smoke` (a numeric id is refused), or the tests refuse to run |
| `SMOKE_GITLAB_URL` | The instance root; default `https://gitlab.com` |

```bash
SMOKE_GITLAB_TOKEN=... SMOKE_GITLAB_PROJECT=me/gitlab-smoke mvn -Psmoke verify
```

Every object a test creates is named `smoke-<run id>-...` and is deleted in a `finally` block; `CleanupSmokeIT` sweeps the
leftovers of an earlier, interrupted run (labels, branches and issues whose name starts with `smoke-`). Use a project that
holds nothing else: the sweep deletes issues.
