package snippet;

public class Snippet {
	<div th:object="${cliente}" th:remove="tag">
				<ul th:if="${#fields.hasErrors('*')}" class="alert alert-danger"
					role="alert">
					<li th:each="err : ${#fields.errors('*')}" th:text="${err}"></li>
				</ul>
			</div>
}

