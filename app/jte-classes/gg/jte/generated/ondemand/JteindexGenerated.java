package gg.jte.generated.ondemand;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.html";
	public static final int[] JTE_LINE_INFO = {17,17,17,17,17,17,17,39,39,39,39,39,39};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <title>Анализатор страниц</title>\n\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n</head>\n<body>\n\n<div class=\"container-fluid bg-dark p-5\">\n    <div class=\"row\">\n        <div class=\"col-md-10 col-lg-8 mx-auto text-white\">\n            <h1 class=\"display-4\">Анализатор страниц</h1>\n            <p class=\"lead\">Бесплатно проверяйте сайты на SEO пригодность</p>\n\n            ");
		jteOutput.writeContent("\n            <form action=\"/urls\" method=\"post\" class=\"rss-form text-body\">\n                <div class=\"row\">\n                    <div class=\"col\">\n                        <div class=\"form-floating\">\n                            <input id=\"url-input\" autofocus type=\"text\" required name=\"url\" aria-label=\"url\"\n                                   class=\"form-control w-100\" placeholder=\"ссылка RSS\" autocomplete=\"off\">\n                            <label for=\"url-input\">Ссылка</label>\n                        </div>\n                    </div>\n                    <div class=\"col-auto\">\n                        <button type=\"submit\" class=\"h-100 btn btn-lg btn-primary px-sm-5\">Проверить</button>\n                    </div>\n                </div>\n            </form>\n\n            <p class=\"mt-2 mb-0 text-muted\">Пример: https://ru.hexlet.io/</p>\n        </div>\n    </div>\n</div>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
