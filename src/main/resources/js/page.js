$("#submit").click(function(e)
{
    e.preventDefault()
    var name = $("#nom").val();
    var age = $("#age").val();

    console.log(name, age)
})