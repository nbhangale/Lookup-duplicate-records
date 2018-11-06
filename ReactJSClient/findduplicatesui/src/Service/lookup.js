module.exports.getDuplicateData = (data) => {
    var formData = new FormData();
    formData.append('file', data);

    // Fetch from web api
    return fetch('https://blooming-eyrie-63560.herokuapp.com/nonduplicate', {
      method: 'POST',
      body: formData
    }).then(res => {
     return res.json();
    }).catch(err => {throw err});
}