var $ = {
    get: function (url, fn) {
        // 发送请求，创建xhr对象
        var xhr = new XMLHttpRequest();
        // 设置对象的请求方式和请求url
        xhr.open("get", url);
        // 发送请求
        xhr.send(null);
        // 等待
        xhr.onreadystatechange = function () {
            if (this.readyState === 4) {
                fn(this.responseText);
            }
        };
    },

    post: function (url, data, fn) {
        // 发送请求，创建xhr对象
        var xhr = new XMLHttpRequest();
        // 设置对象的请求方式和请求url
        xhr.open("post", url);
        // 发送请求
        xhr.send(data);
        // 等待
        xhr.onreadystatechange = function () {
            if (this.readyState === 4) {
                fn(this.responseText);
            }
        };
    }
}