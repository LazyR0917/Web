import axios from 'axios'

// 创建 axios 实例，统一基础路径
const request = axios.create({
  baseURL: '/api',     // 注意：有 vite 代理，会自动转发到 http://localhost:8080/api
  timeout: 5000
})

/** 登录接口 */
export function loginApi(username, password) {
  return request.post('/user/login', { username, password })
}

/** 注册接口 */
export function registerApi(username, password) {
  return request.post('/user/register', { username, password })
}

/** 测试接口 */
export function helloApi() {
  return request.get('/user/hello')
}