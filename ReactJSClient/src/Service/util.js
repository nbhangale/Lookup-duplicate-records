module.exports.getDuplicateData = (data) => {
    var formData = new FormData();
    formData.append('file', data);

    return fetch('http://localhost:8081/lookup', {
      method: 'POST',
      body: formData
    }).then(res => {
     // console.log(res);
     return res.json();
    }).catch(err => {throw err});
}