/**
 * 接口处理函数封装.
 * @param method 请求类型
 * @param url 请求地址
 * @param params 请求参数
 * @param successFunction 服务器响应成功执行的方法
 * @param failureFunction 服务器响应失败执行的方法
 * @param errorFunction   服务器响应异常执行的方法
 */
function apiAxios(method, url, params, successFunction, failureFunction, errorFunction) {
	axios({
		method: method,
		url: url,
		params: params,
		// 允许跨域请求
		withCredentials: true
	})
			.then(function(response) {
				if (response.data.status === 200) {
					if (successFunction) {
						successFunction(response.data)
					}
				} else if (response.data.status !== 200) {
					if (failureFunction) {
						failureFunction(response.data)
					}
				}
			})
			.catch(function(exception) {
				if (exception) {
					// 服务器异常响应
					if (errorFunction) {
						errorFunction(exception)
					} else {
						console.log(exception)
					}
				}
			})
}

const http = {
	get: function(url, params, successFunction, failureFunction, errorFunction) {
		return apiAxios('GET', url, params, successFunction, failureFunction, errorFunction)
	},
	post: function(url, params, successFunction, failureFunction, errorFunction) {
		return apiAxios('POST', url, params, successFunction, failureFunction, errorFunction)
	},
	put: function(url, params, successFunction, failureFunction, errorFunction) {
		return apiAxios('PUT', url, params, successFunction, failureFunction, errorFunction)
	},
	delete: function(url, params, successFunction, failureFunction, errorFunction) {
		return apiAxios('DELETE', url, params, successFunction, failureFunction, errorFunction)
	},
	patch: function(url, params, successFunction, failureFunction, errorFunction) {
		return apiAxios('PATCH', url, params, successFunction, failureFunction, errorFunction)
	}
};