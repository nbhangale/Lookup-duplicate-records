module.exports.getDuplicateData = (data) => {
    var formData = new FormData();
    formData.append('file', data);

    // Fetch from web api
    return fetch('http://localhost:8081/nonduplicate', {
      method: 'POST',
      body: formData
    }).then(res => {
     return res.json();
    }).catch(err => {throw err});
}