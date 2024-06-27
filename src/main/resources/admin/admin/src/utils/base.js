const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot224bf/",
            name: "springboot224bf",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot224bf/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智慧社区网站"
        } 
    }
}
export default base
