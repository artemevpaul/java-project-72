@import hexlet.code.dto.UrlPage
@import hexlet.code.util.NamedRoutes
@param UrlPage page

@template.layout.page(
content = @`
    <main class="flex-grow-1">
        <div>
            @if(page != null && page.getFlash() != null)
                <div class="rounded-0 m-0 alert alert-dismissible fade show alert-${page.getFlashType()}" role="alert">
                    <p class="m-0">${page.getFlash()}</p>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            @endif
        </div>
        <section>
            <div class="container-lg mt-5">
                <h1>Сайт: ${page.getUrl().getName()}</h1>

                <table class="table table-bordered table-hover mt-3">
                    <tbody>
                    <tr>
                        <td>ID</td>
                        <td>${page.getUrl().getId()}</td>
                    </tr>
                    <tr>
                        <td>Имя</td>
                        <td>${page.getUrl().getName()}</td>
                    </tr>
                    <tr>
                        <td>Дата создания</td>
                        <td>${page.getUrl().getCreatedAt().toString()}</td>
                    </tr>
                    </tbody>
                </table>
                <h2 class="mt-5">Проверки</h2>

                <form action="${NamedRoutes.urlChecksPath(page.getUrl().getId())}" method="post">
                    <input type="submit" class="btn btn-primary" value="Запустить проверку"/>
                </form>

                <table class="table table-bordered table-hover mt-3">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Код ответа</th>
                        <th scope="col">title</th>
                        <th scope="col">h1</th>
                        <th scope="col">description</th>
                        <th scope="col">Дата проверки</th>
                    </tr>
                    </thead>
                    @if(page.getChecksList() != null)
                        @for(var urlCheck : page.getChecksList())
                            <tr>
                                <td>${urlCheck.getId()}</td>
                                <td>${urlCheck.getStatusCode()}</td>
                                <td>${urlCheck.getTitle()}</td>
                                <td>${urlCheck.getH1()}</td>
                                <td>${urlCheck.getDescription()}</td>
                                <td>${String.valueOf(urlCheck.getCreatedAt())}</td>
                            </tr>
                        @endfor
                    @endif
                </table>

            </div>
        </section>
    </main>
`
)