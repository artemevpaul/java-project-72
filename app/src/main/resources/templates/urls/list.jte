@importhexlet.code.util.NamedRoutes
@import hexlet.code.dto.UrlsPage
@param UrlsPage page


@template.layout.page(
content = @`
    <main class="flex-grow-1">

        <section>

            <div class="container-lg mt-5">
                <h1>Сайты</h1>

                <table class="table table-bordered table-hover mt-3">

                    <thead>
                    <tr>
                        <th class="col-1">ID</th>
                        <th>Имя</th>
                        <th class="col-2">Последняя проверка</th>
                        <th class="col-1">Код ответа</th>
                    </tr>
                    </thead>
                    @for(var url : page.getUrls())
                    <tbody>
                    <tr>
                        <td>
                            ${url.getId()}
                        </td>

                        <td>
                            <a href="${NamedRoutes.urlPath(url.getId())}">${url.getName()}</a>
                        </td>
                        <td>${url.getLastCheck() == null ? "Проверка не проводилась" : url.getLastCheck().getCreatedAt().toString()}</td>
                        <td>${url.getLastCheck() == null ? "Проверка не проводилась" : String.valueOf(url.getLastCheck().getStatusCode())}</td>
                    </tr>
                    @endfor
                    </tbody>
                </table>
            </div>
        </section>
    </main>
`
)