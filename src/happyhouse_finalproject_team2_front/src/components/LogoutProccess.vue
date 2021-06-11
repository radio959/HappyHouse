<script>
export default {
    created() {
        sessionStorage.clear();
        location.href="/";
    }
}
</script>