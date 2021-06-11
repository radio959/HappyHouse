<script>
export default {
    created() {
        let url = new URL(location.href);
        let name = url.searchParams.get("name");
        let email = url.searchParams.get("email");
        let picture = url.searchParams.get("picture");
        
        if(name != null &&  email != null && picture != null) {
          var user = {
            name,
            email,
            picture
          }
          sessionStorage.setItem("user", user);
        }
        location.href="/";
    }
}
</script>