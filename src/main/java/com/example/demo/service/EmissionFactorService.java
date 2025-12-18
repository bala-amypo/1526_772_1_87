public interface EmissionFactorService {
    EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor);
    EmissionFactor getFactor(Long id);
    EmissionFactor getFactorByType(Long activityTypeId);
    List<EmissionFactor> getAllFactors();
}
